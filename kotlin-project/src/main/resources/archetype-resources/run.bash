echo "-> Run bash individually - Type '${artifactId}build' to build the project"
${artifactId}build() {
  echo "mvn clean package"
  mvn clean package
}
echo "-> Run bash individually - Type '${artifactId}run' to run the executable"
${artifactId}run() {
  echo "Running executable > java -jar target/${artifactId}-${version}.jar"
  java -jar target/${artifactId}-${version}.jar
}

${artifactId}build
${artifactId}run