export SDK=$1
export VERSION=$2
export LIB="${SDK}/lib"

echo Installing App Engine jars from ${LIB} to ${REPO}

mvn -npr install:install-file \
	-Dfile="${LIB}/user/appengine-api-1.0-sdk-${VERSION}.jar" \
	-DgroupId=com.google.appengine \
	-DartifactId=appengine-api-1.0-sdk \
	-Dversion=${VERSION} \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DcreateChecksum=true

mvn -npr install:install-file \
	-Dfile="${LIB}/user/appengine-api-1.0-sdk-${VERSION}.jar" \
	-DgroupId=com.google.appengine \
	-DartifactId=appengine-api-1.0-sdk \
	-Dversion=${VERSION} \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DcreateChecksum=true

mvn install:install-file \
	-Dfile="${LIB}/appengine-tools-api.jar" \
	-DgroupId=com.google.appengine \
	-DartifactId=appengine-tools-api \
	-Dversion=${VERSION} \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DcreateChecksum=true

mvn install:install-file \
	-Dfile="${LIB}/impl/appengine-api.jar" \
	-DgroupId=com.google.appengine \
	-DartifactId=appengine-api \
	-Dversion=${VERSION} \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DcreateChecksum=true

mvn install:install-file \
	-Dfile="${LIB}/impl/appengine-api-labs.jar" \
	-DgroupId=com.google.appengine \
	-DartifactId=appengine-api-labs \
	-Dversion=${VERSION} \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DcreateChecksum=true

mvn install:install-file \
	-Dfile="${LIB}/testing/appengine-testing.jar" \
	-DgroupId=com.google.appengine \
	-DartifactId=appengine-testing \
	-Dversion=${VERSION} \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DcreateChecksum=true
	
mvn install:install-file \
	-Dfile="${LIB}/impl/appengine-api-stubs.jar" \
	-DgroupId=com.google.appengine \
	-DartifactId=appengine-api-stubs \
	-Dversion=${VERSION} \
	-Dpackaging=jar \
	-DgeneratePom=true \
	-DcreateChecksum=true
	
