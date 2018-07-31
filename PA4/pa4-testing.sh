#!/usr/bin/bash

#CHANGE DEBUG VALUE TO 1 TO SAVE DIFF REPORTS!!!!!!!!!
DEBUG=0

SRCDIR=https://raw.githubusercontent.com/rcompt/cmps012b-pt.u18/master/PA4/
NUMTESTS=5
PNTSPERTEST=8
let MAXPTS=$NUMTESTS*$PNTSPERTEST

if [ ! -e backup ]; then
  echo "WARNING: a backup has been created for you in the \"backup\" folder"
  mkdir backup
fi

cp *.java Makefile backup   # copy all files of importance into backup

for NUM in $(seq 1 $NUMTESTS); do
  curl $SRCDIR/infile$NUM > infile$NUM
  curl $SRCDIR/model-rpt$NUM.txt > model-rpt$NUM.txt
  curl $SRCDIR/model-trc$NUM.txt > model-trc$NUM.txt
done

curl $SRCDIR/ModelQueueTest.java > ModelQueueTest.java
curl $SRCDIR/TestObj1.java > TestObj1.java
curl $SRCDIR/Makefile_test > Makefile_test

echo ""
echo ""

echo "Press Enter To Continue with QueueTest Results"
read verbose
echo ""
echo ""
make -f Makefile_test
echo ""
echo ""
timeout 5 java ModelQueueTest -v > QueueTest-out.txt &>> QueueTest-out.txt
progresult="$(tail -n 1 QueueTest-out.txt)"
head -n -1 QueueTest-out.txt

echo ""
echo ""

make -f Makefile_test clean


echo ""
echo ""
echo "Press enter to continue to check Makefile"
read verbose

make

if [ ! -e Simulation ] || [ ! -x Simulation ]; then # exist and executable
  echo ""
  echo "Makefile doesn't correctly create Executable!!!"
  echo ""
  rm -f *.class
  javac -Xlint *.java
  echo "Main-class: Simulation" > Manifest
  jar cvfm Simulation Manifest *.class
  rm Manifest
  chmod +x Simulation
fi

echo ""
echo ""

simulationtestspassed=$(expr 0)
echo "Please be warned that the following tests discard all output to stdout/stderr"
echo "Simulation tests: If nothing between '=' signs, then test is passed"
echo "Press enter to continue"
read verbose
for NUM in $(seq 1 $NUMTESTS); do
  rm -f outfile$NUM.txt
  timeout 5 Simulation infile$NUM &> garbage >> garbage
  diff -bBwu infile$NUM.rpt model-rpt$NUM.txt &> diff-rpt$NUM.txt >> diff-rpt$NUM.txt
  diff -bBwu infile$NUM.trc model-trc$NUM.txt &> diff-trc$NUM.txt >> diff-trc$NUM.txt
  echo "Report $NUM Test:"
  echo "=========="
  cat diff-rpt$NUM.txt
  echo "=========="
  echo "Trace $NUM Test:"
  echo "=========="
  cat diff-trc$NUM.txt
  echo "=========="

  cat diff-rpt$NUM.txt diff-trc$NUM.txt > diff$NUM.txt

  if [ -e diff$NUM.txt ] && [[ ! -s diff$NUM.txt ]]; then
    let simulationtestspassed+=1
  fi

  if [ "$DEBUG" -eq "0" ]; then
    rm -f infile$NUM *.rpt *.trc diff*$NUM* model-rpt$NUM.txt model-trc$NUM.txt
  fi

done

echo ""
echo ""

let simulationtestpoints=$PNTSPERTEST*$simulationtestspassed

echo "Passed $simulationtestspassed / $NUMTESTS Simulation tests"
echo "This gives a total of $simulationtestpoints / $MAXPTS points"
echo ""

make clean

if [ -e Simulation ] || [ -e *.class ]; then
  echo "WARNING: Makefile didn't successfully clean all files"
  rm -f Simulation *.class
fi

echo ""
echo ""
GIMMEPOINTS=20
let finalpoints=$progresult+$simulationtestpoints+$GIMMEPOINTS

echo "*******************************"
echo "Final Score: $finalpoints / 100"
echo "*******************************"

if [ "$DEBUG" -eq "0" ]; then
	rm -f *out.txt
	rm -f *.class ModelQueueTest* garbage* TestObj1*
	rm -f Makefile_test
fi


