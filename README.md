## Installation

```
> git clone git@github.com:imranraja85/ ?????
> cd drugs/
> lein uberjar
> java -jar target/drugs-0.1.0-SNAPSHOT-standalone.jar data.txt
```

## Usage

After compiling the drug smuggling app, execute the jar file and pass in the data file as the argument
```
> java -jar target/drugs-0.1.0-SNAPSHOT-standalone.jar data.txt
```

## Data File Setup
The first line of the input file contains the maximum weight. The remaining lines each contain a space delimited record in the following order: name weight value

Sample file:
```
> 100
> luke        9   150
> anthony    13    35
> candice   153   200
```

## License

Distributed under the Eclipse Public License, the same as Clojure.
