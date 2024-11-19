# Language : EN

## How does it work?

### 1) build-convention: Managing maven repositories and dependencies

The `build-convention`project is a multi-module project that allows you to manage maven dependencies and repositories centrally.
centrally.

To modify dependencies, go to `catalog/build.gradle.kts` and define dependencies like the JSON example. Dependency versions can be defined using the function or in `gradle.properties`.

To modify maven repositories, go to `plugin/GradleRepositoriesPlugin.kt` and define them in the
function.
The `defineRepositories()` function contains the dependency repositories.

### 2) main-project: Project using the `build-convention` plugin

To use the `build-convention` plugin, you need to add it to the `settings.gradle.kts` file.
If you're using a specific maven repository, remember to add it to `pluginManagement` so that you can import
build-convention`.

## Why do this?

The aim is to manage dependency versions centrally and update them easily in the case of
of a project with several modules and/or several gradle projects: this avoids version desynchronization.
It also lightens the load on projects'   build.gradle.kts files by defining dependencies and maven repositories within a
a project.

## Architectural choice

The plugin and catalog have the same version. This avoids juggling several versions without understanding what you're
manipulating.

# Langue : FR

## Comment cela fonctionne-t-il ?

### 1) build-convention : Gestion des dépôts maven et des dépendances

Le projet `build-convention` est un projet multi-module qui permet de gérer les dépendances et les dépôts maven de
manière centralisée.

Pour modifier les dépendances, il faut se rendre dans `catalog/build.gradle.kts` et définir les dépendances comme l'exemple de JSON. Les versions des dépendances peuvent être défini grâce à la fonction ou dans `gradle.properties`.

Pour modifier les dépôts maven, il faut se rendre dans `plugin/GradleRepositoriesPlugin.kt` et les définir dans la
fonction prévue à cet effet.
La fonction `defineRepositories()` contient les dépôts des dépendances.

### 2) main-project : Projet utilisant le plugin `build-convention`

Pour utiliser le plugin `build-convention`, il faut ajouter le plugin dans le fichier `settings.gradle.kts`.
Si vous utilisez un dépôt maven spécifique, pensez l'à ajouter dans `pluginManagement` afin de pouvoir importer
`build-convention`.

## Pourquoi faire cela ?

Le but est de gérer les versions des dépendances de manière centralisée et de les mettre à jour facilement dans le carde
d'un projet avec plusieurs modules et/ou plusieurs projets gradle : cela évite la désynchronisation des versions.
Cela allège également le fichier `build.gradle.kts` des projets en définissant les dépendances et les dépôts maven dans
un projet.

## Choix architectural

Le plugin et le catalog ont la même version. Cela évite de jongler avec plusieurs versions sans comprendre ce que l'on
manipule.