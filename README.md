
# Comment cela fonctionne-t-il ?

## build-convention : Gestion des dépôts maven et des dépendances

Le projet `build-convention` est un projet multi-module qui permet de gérer les dépendances et les dépôts maven de manière centralisée.

Pour modifier les dépendances, il faut se rendre dans `catalog` et définir les versions des dépendances dans `gradle.properties`.

Pour modifier les dépôts maven, il faut se rendre dans `plugins` > `GradleRepositoriesPlugin.kt` et les définir dans la fonction prévue à cet effet.
Les fonctions `RepositoryHandler.defineRepositories()` contiennent les dépôts des dépendances.

## main-project : Projet utilisant le plugin `build-convention`

Pour utiliser le plugin `build-convention`, il faut ajouter le plugin dans le fichier `settings.gradle.kts`.
Si vous utilisez un dépôt maven spécifique, pensez l'à ajouter dans `pluginManagement` afin de pouvoir importer `build-convention`.
Définissez la même version du plugin dans `gradle.properties` que celle définie dans `build-convention` avec la clé `plugin-version`.

# Pourquoi faire cela ?

Le but est de gérer les versions des dépendances de manière centralisée et de les mettre à jour facilement dans le carde d'un projet avec plusieurs modules et/ou plusieurs projets gradle : cela évite la désynchronisation des versions.
Cela allège également le fichier `build.gradle.kts` des projets en définissant les dépendances et les dépôts maven dans un projet.