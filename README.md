
# Comment cela fonctionne-t-il ?

## catalog : Catalogues des dépendances

Le project `catalog` est un projet gradle de définition de dépendances.
Il contient trois principaux plugins :
 - base : ajoute le minimum des fonctionnalités pour un projet gradle.
 - `version-catalog` : permet de définir un catalogue de versions de dépendances.
 - `maven-publish` : permet de publier les artefacts du projet dans un dépôt maven.


Les versions des dépendances et la version du catalogue se définissent dans le fichier `gradle.properties`.
Les dépendances se définissent dans le fichier `build.gradle.kts`. Il faut définir la référence de la version de chaque dépendance et la librairie.

## main-project : Projet utilisant le catalogue

Pour utiliser le catalogue, il faut définir la version du catalogue dans le fichier `gradle.properties` du projet, puis créer une librairie à partir du catalogue dans le fichier `build.gradle.kts`.
N'oubliez pas d'ajouter vos dépôts maven où est publié le catalogue et les dépendances utilisées dans le catalogue.

PS : Je suis en recherche pour centraliser aussi les dépôts maven dans le catalogue ou dans un plugin gralde afin de pouvoir définir les dépôts qu'une seule fois. Si vous avez la solution, n'hésitez pas à faire une PR. Le seul dépôt maven qu'il faudra donc mettre sera celui du catalogue.

# Pourquoi faire cela ?

Le but est de gérer les versions des dépendances de manière centralisée et de les mettre à jour facilement dans le carde d'un projet avec plusieurs modules et/ou plusieurs projets gradle : cela évite la désynchronisation des versions.