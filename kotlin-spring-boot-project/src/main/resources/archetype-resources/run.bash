echo "-> Run bash individually - Type '${artifactId}build' to build the project"
${artifactId}build() {
  echo "mvn clean package"
  mvn clean package
}
echo "-> Run bash individually - Type '${artifactId}run' to run the executable"
${artifactId}run() {
  echo "Running executable > mvn spring-boot:run"
  mvn spring-boot:run
}

${artifactId}build
${artifactId}run