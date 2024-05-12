rootProject.name = "${artifactId}"

//include(
//    ""
//)

rootProject.children.forEach {
    it.name = it.name.replace("/", "_")
}