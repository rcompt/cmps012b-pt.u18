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

Be sure to copy over your Queue.java, QueueInterface.java, QueueTest.java, QueueEmptyException.java, Simulation.java, Job.java, and Makefile files to the new directory ("pa4_testing"), before running pa4-testing.sh

## Running

```bash
DicitonaryModelTest
```
