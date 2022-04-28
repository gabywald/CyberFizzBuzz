# Perl Communications (Sockets)

## Description

  * Écrire deux programmes en Perl.
  * Le premier que nous appellerons « client » établit n connexions TCP à un serveur.
  * Sur chaque connexion, il envoie toutes les 50ms un timestamp en millisecondes.
  * Le second que nous appellerons « serveur » réceptionne les timestamps provenant des n connexions, les ordonne et les range dans un fichier.
  * Ces différentes actions sont faites en continue, le client envoie des données en permanence, le serveur les reçoit en continu et, au fur et à mesure les ordonne et les stocke.
  * Ces deux programmes doivent être écrits en Perl, on privilégiera les modules simples et légers si besoin.

**Le petit plus** : Dans le cas où n=50, le même timestamp risque d'être envoyé plusieurs fois. Faire une évolution du serveur afin qu'il supprime les doublons, l'idée est que les timestamps reçus n'apparaissent dans le fichier qu'une seule fois. 

## Contexte de développement

Ubuntu 20.04 LTS
Perl 5.30.0

## Code développé

Deux scripts à utliser : 
  * timestamp_server.pl
  * timestamp_client.pl

Penser à attribuer les droits nécessaire en execution !

Les autres éventuels documents et scripts présents sont là à titre de documentation et expliciter certains éléments. 
