# cyberfizzbuzz-picocli


Directement dans répertoire courant (pas parent dans ce cas) : "mvn clean package"

puis "java -jar target/cyberfizzbuzz-cli-jar-with-dependencies.jar --help"

```
Usage: cyberfizzbuzz [-hvV] [-c=<configFile>] [COMMAND]
Application CLI avec picocli.
  -c, --config=<configFile>
                  Fichier de configuration.
  -h, --help      Show this help message and exit.
  -v, --verbose   Active le mode verbeux.
  -V, --version   Print version information and exit.
Commands:
  sub1  Première sous-commande.
  sub2  Deuxième sous-commande.

```

> java -jar target/cyberfizzbuzz-cli-jar-with-dependencies.jar sub2 -c=src/test/resources/gabywald/comexample/custom.conf toto
SubCommand2: param=toto, verbose=false, config=src/test/resources/gabywald/comexample/custom.conf

> java -jar target/cyberfizzbuzz-cli-jar-with-dependencies.jar sub1 -c=src/test/resources/gabywald/com/example/custom.conf toto
SubCommand1: param=toto, verbose=false, config=src/test/resources/gabywald/com/example/custom.conf

> java -jar target/cyberfizzbuzz-cli-jar-with-dependencies.jar sub1 -v toto
SubCommand1: param=toto, verbose=true, config=config.properties

> java -jar target/cyberfizzbuzz-cli-jar-with-dependencies.jar sub1 -v toto -c null
SubCommand1: param=toto, verbose=true, config=null

> java -jar target/cyberfizzbuzz-cli-jar-with-dependencies.jar sub2 -v toto -c null
SubCommand2: param=toto, verbose=true, config=null


> java -jar target/cyberfizzbuzz-cli-jar-with-dependencies.jar sub2 -v toto -c null -h
Usage: cyberfizzbuzz sub2 [-hvV] [-c=<configFile>] <param>
Deuxième sous-commande.
      <param>     Paramètre spécifique à sub2.
  -c, --config=<configFile>
                  Fichier de configuration.
  -h, --help      Show this help message and exit.
  -v, --verbose   Active le mode verbeux.
  -V, --version   Print version information and exit.
