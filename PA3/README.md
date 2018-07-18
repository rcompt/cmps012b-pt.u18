## Installation

```bash
mkdir pa3_testing
cd pa3_testing
curl https://raw.githubusercontent.com/rcompt/cmps012b-pt.u18/master/PA3/Makefile_Test >> Makefile_Test
curl https://raw.githubusercontent.com/rcompt/cmps012b-pt.u18/master/PA3/ModelDictionaryTest.java >> ModelDictionaryTest.java
```

Be sure to copy over your Dictionary.java, DictionaryInterface.java, KeyNotFoundException.java, and DuplicateKeyException.java files to the new directory ("pa3_testing"), before running the make file

## Running

```bash
make -f Makefile_Test
ModelDictionaryTest
```
