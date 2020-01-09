# ApplicationGestionPepiniere
# Application avec une base de données oracle pour mettre en évidence l'administration oracle 
# base de données : oracle Express 11g
# Pattern segleton : pour la connexion à la base
# Les mots de passes et les noms des utilisateurs sont récuperer à la connexion
# Installer OpenJDK11
# voir dans le built path pour ajouter les bibliothèques manquantes pour le bon fonctionnement de l'application.
# Quatre utilisateurs dont admin, jardinier, commercial et gerant.
# admin a tous les droits
# jardinier gère les stocks
# commercial gère les commandes, les clients
# gerant gère la statisque 
# Connection à l'application :

Nom                          Mot de passe         Roles
admin                       admin               DBA
jardinier                   jardinier           connect, jardinier
commercial                  commercial          connect, commercial
gerant                      gerant              connect, gerant
