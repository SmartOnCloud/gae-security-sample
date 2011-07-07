GAE authorization example
=========================

To run example locally first download google app engine for java version 1.5.1. And invoke included script to install jars into local maven repository.

    ./mvn-install-appengine-jars.sh <path_to_app_engine> 1.5.1

compile:

    mvn compile war:exploded

run:
    ./dev_appserver.sh target/gae-security

and navigate to [ http://localhost:8080 ].



