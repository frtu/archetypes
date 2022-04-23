rootProject.name = "${artifactId}"

include(
    "${artifactId}-publisher",
    "${artifactId}-stream"
)

rootProject.children.forEach {
    it.name = it.name.replace("/", "_")
}