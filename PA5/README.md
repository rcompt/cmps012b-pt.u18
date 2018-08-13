## Installation

```bash
mkdir pa5_testing
cp Dictionary.h pa5_testing/Dictionary.h
cp Dictionary.c pa5_testing/Dictionary.c
cd pa5_testing
curl https://raw.githubusercontent.com/rcompt/cmps012b-pt.u18/master/PA5/Makefile_test >> Makefile_test
curl https://raw.githubusercontent.com/rcompt/cmps012b-pt.u18/master/PA5/DictionaryModelTest.c >> DictionaryModelTest.c
make -f Makefile_test
```

Be sure that the output file DictionaryModelTest has been created and that your Dictionary.c and Dictionary.h files were copied over correctly.

## Running

```bash
DictionaryModelTest
```
