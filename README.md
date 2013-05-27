## Description

This is my solution for the AO drug smuggling challenge

## Installation

```
> git clone https://github.com/imranraja85/drug_smuggler.git
> cd drug_smuggler/
> lein uberjar
```

## Usage

After compiling drug_smuggler, execute the jar file and pass in the data file as an argument
```
> java -jar target/drugs-0.1.0-SNAPSHOT-standalone.jar data.txt
```

## Data File Setup
The first line of the input file contains the maximum weight. The remaining lines each contain a space delimited record in the following order: name weight value

Sample file:
```
100
luke        9   150
anthony    13    35
candice   153   200
```

## Testing
To run the test suite:
```
lein test
```

## License

Distributed under the Eclipse Public License, the same as Clojure.
