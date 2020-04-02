# Projet_Informatique_Repartie

## Equipes
* Chef de projet
   * Adrien
* Equipe infrastructure d'accueil
   * ...
   * ...
* Equipe solution java
   * Jihane ( 2 agents distincts : agents texte et agent image ) 
   * Jonas (Aiguilleur)
   * Renaud
   * ...

## Répartition du travail
* La première équipe sera assignée à la mise en place de l’infrastructure d'accueil de notre solution, soyez sûrs d’être à l’aise avec la virtualisation et la communication entre les programmes java, à savoir :
    * Mise en place de 2 machines virtuelles sur une de vos machines :
        * La 1ere correspondra à “frodon1” dans le support qui nous est fourni
        * La 2eme correspond alors  à “frodon2”.
    * La machine locale aura quand à elle pour rôle d'accueillir l’agent aiguilleur 
    * L’idée principale ici est de mettre en place, sur une de vos machines et sur 2 machines virtuelles, des programmes java basiques qui sont capables de communiquer entre eux, à vous de voir quelle structure de données et quelle technique vous utiliserez, à savoir qu’il faudra que ce soit implémentable au sein des agents par la suite.

* La 2eme équipe sera en charge de développer une solution en java, dans un premier temps en local, répondant à la solution attendue.
    * Gardez en tête qu’aucun agent n’a de connaissance globale du réseau, l’agent aiguilleur a une connaissance des agents compteurs présents sur le réseau, les agents compteurs ont une connaissance locale des agents présents sur la même machine qu’eux.
    * Un agent aiguilleur (machine principale) qui va avoir pour rôle de déterminer la probabilité (ce calcul est représenter par la formule présente dans le slide correspondant à la normalisation de la probabilité du taux de phéromone d’une machine ou truc dans le genre) qu’une information se trouve sur l’une ou l’autre machine virtuelle du réseau en passant par des agents compteurs présents sur chaque machine. Cet agent n’aura connaissance que des agents compteurs présents sur chaque machine.
    * 2 agents compteurs, (un sur chaque machine virtuelle par la suite), responsables d’incrémenter un compteur de “phéromone”, permettant d’augmenter la probabilité qu’une seconde recherche aboutisse au même chemin.
    * 2 agents distincts qui seront développés sur les deux machines virtuelles :
        * Un agent texte, capable de déterminer si une recherche correspond à une information qu’il est capable de fournir (donc si c’est du texte)
        * Un agent “image”, capable de déterminer si une information recherchée est une image et est capable de la fournir.
