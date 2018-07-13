SRCDIR=https://raw.githubusercontent.com/rcompt/cmps012b-pt.u18/master/PA2/
NUMTESTS=2
NUMVERSIONS=2
PNTSPERTEST=10
let MAXPTS=$NUMTESTS*$PNTSPERTEST

if [! -e backup ]; then
	echo "WARNING: a backup has been created for you in the \"backup\" folder"
  	mkdir backup
fi

cp *.java Makefile backup   # copy all files of importance into backup

curl $SRCDIR/Makefile_test > Makefile_test
curl $SRCDIR/SearchTest.java > SearchTest.java

for NUM in $(seq 1 $NUMTESTS); do
  curl $SRCDIR/infile$NUM.txt > infile$NUM.txt
  for VERSION in $(seq 1 $NUMVERSIONS); do
  curl $SRCDIR/model-outfile$NUM-$VERSION.txt > model-outfile$NUM-$VERSION.txt
  done
done

echo ""
echo ""

make -f Makefile_test SearchTest

make -f Makefile

if [ ! -e Search ] || [ ! -x Search ]; then # exist and executable
  echo "!!!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!!!!!!!"
  echo "Makefile doesn't correctly create Executable!!!"
  echo ""
  rm -f *.class
  javac -Xlint Search.java
  echo "Main-class: Search" > Manifest
  jar cvfm Search Manifest *.class
  rm Manifest
  chmod +x Search
fi

echo ""
echo ""

SearchTest

echo "Press Enter to Continue with File tests"
read verbose

searchtestspassed=$(expr 0)
searchuseseasymethod=$(expr 0)

testArgs=(\
  [0]=""\
  [1]="10 twelve two 2 65 five 6 six nine 1000 onehundred and 1"\
  )

for NUM in $(seq 1 $NUMTESTS); do
  rm -f outfile$NUM.txt
  timeout 5 Search infile$NUM.txt ${testArgs[NUM - 1]} &> outfile$NUM.txt >> outfile$NUM.txt
  # ideally print out working version diff
  WORKING_VERSION=-1
  for VERSION in $(seq 1 2); do
    if [ "$WORKING_VERSION" -ne "-1" ]; then
      break
    fi
    diff -ZbBwu outfile$NUM.txt model-outfile$NUM-$VERSION.txt &> diff$NUM-$VERSION.txt >> diff$NUM-$VERSION.txt
    if [ -e diff$NUM-$VERSION.txt ] && [[ ! -s diff$NUM-$VERSION.txt ]]; then
      WORKING_VERSION=$VERSION
    fi
  done
  echo "Test $NUM:"
  echo "=========="
  if [ "$WORKING_VERSION" -eq "-1" ]; then
    cat diff$NUM-1.txt
  else
    cat diff$NUM-$WORKING_VERSION.txt
    let searchtestspassed+=1
    if [ "$WORKING_VERSION" -ne "1" ]; then
      searchuseseasymethod=$(expr 1)
    fi
  fi
  echo "=========="
  rm -f infile$NUM* *outfile$NUM* diff$NUM*
done

echo ""
echo ""

let searchtestpoints=$PNTSPERTEST*$searchtestspassed-$searchuseseasymethod*10

echo "Passed $searchtestspassed / $NUMTESTS Search tests"
if [ "$searchuseseasymethod" -ne "0" ]; then
  echo "Be aware that your search tests were marked down 10 points for using the easy method"
fi
echo "This gives a total of $searchtestpoints / $MAXPTS points"

echo ""
echo ""

make -f Makefile clean

if [ -e Search ] || [ -e *.class ]; then
  echo "WARNING: Makefile didn't successfully clean all files"
  make -f Makefile_test clean
fi

rm -f *out.txt *Work.txt

rm -f *.class Model*MergeTest.java garbage*
