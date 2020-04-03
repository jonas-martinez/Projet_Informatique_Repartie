# Equipe Développement Java

* Document explicatif des ontologies : https://docs.google.com/document/d/1DCB9m80faHvD8-veWoahzlGrrYdI2m8vJJrBV79MHQM/edit?usp=sharing

## Comment executer les agents ?

* Se placer dans le dossier "bin" à partir d'une console
* Executer la commande suivante en fonction de l'agent voulu :
  * (WINDOWS) java -cp "../lib/jade.jar;." jade.Boot -gui cpt:compteur.AgentCompteur
  * (LINUX) java -cp "../lib/jade.jar:." jade.Boot -gui cpt:compteur.AgentCompteur
  * "cpt" correspond au nom que l'on donnera à l'agent lors de son execution, il sera sûrement à modifier (je ferais une doc pour chaque agent dans la journée)
  * compteur.AgentCompteur est le chemin vers l'agent à executer, si on avait voulu executer l'aiguilleur cela serait : aiguilleur.Aiguilleur
