# TreeTableViewMvvmFX

A simple application of TreeTableView with the mvvmFX framework.

It uses a `RecursiveTreeItem<T> extends TreeItem<T>` implemented by [lestard](https://gist.github.com/lestard/011e9ed4433f9eb791a8).
The tree branch actually uses a Tree as data source. It creates a Tree from a List of paths to files. It was implemented by [SchulteMarkus](https://stackoverflow.com/questions/10929775/java-tree-to-represent-filesystem-files-dir-from-list-of-paths)