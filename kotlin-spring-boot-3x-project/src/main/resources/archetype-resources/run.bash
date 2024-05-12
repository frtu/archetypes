echo "-> Run bash individually - Type '${artifactId}build' to build the project"
${artifactId}build() {
  echo "mvn clean package"
  mvn clean package
}
echo "-> Run bash individually - Type '${artifactId}k8s' to run the executable"
${artifactId}k8s() {
  echo "Running executable > mvn k8s:resource k8s:build"
  mvn k8s:resource k8s:build
}
echo "-> Run bash individually - Type '${artifactId}registryk8s' to run the executable"
${artifactId}k8sregistry() {
  echo "Running executable > mvn k8s:resource k8s:build k8s:push -Pregistry-k8s"
  mvn k8s:resource k8s:build k8s:push -Pregistry-k8s
}
echo "-> Run bash individually - Type '${artifactId}run' to run the executable"
${artifactId}run() {
  echo "Running executable > mvn spring-boot:run"
  mvn spring-boot:run
}
