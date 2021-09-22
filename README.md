# CyberFizzBuzz

Tests Fizz Buzz de recrutement en programmation (et réflexions associées)

Les examples de code proposés à côté sont en java, mais ce n'est pas le plus important

## Concept / idée du test

Une liste de nombres à afficher : 
* si l'un d'entre eux est multiple de 3, afficher 'fizz'. 
* si l'un d'entre eux est multiple de 5 : afficher 'buzz'. 
* si l'un d'entre eux est multiple de 3 ET de 5 : afficher 'fizzbuzz'. 

Quelques variantes possibles dans cet énoncé pour voir les concepts de programmation connus par la personne passant le test. 
* base : programmation similaire à un 'Hello World'
* lambda / stream : traitements en chaine
* objet / interface : Programmation Orientée Objet (POO)

L'intérêt est que le candidat *explique* la démarche (et montre également comment il a comprit l'énoncé). Attention aux énoncés mal formulés ! (ici, ni exhaustif ni représentatif ; faire tester en aveugle si besoin). 

Ouvert à d'autres idées sur le même principe, de la même façon que http://99-bottles-of-beer.net/ <http://99-bottles-of-beer.net/>

La principale idée du CyberFizzBuzz est de tester les compétences d'un développeur en faisant du code ET de la revue de code lors d'un entretien en temps limité. 

## Autres tests

Tests pour éprouver les connaissances sur usage des Interfaces, des patrons de conception (Design Patterns) et des différents niveaux d'accessibilité. 

Façon de voir et vérifier la façon de coder en général. 

Il existe aussi des variantes en algorithmie (façon de décompter la monnaie, trier les instances d'objets...), un exercice de style. 

### Monnayeur / ChangeMachine / SlotMachine

Sur une machine composée de 'slots' contenant des pièces : à partir d'un montant donné en entrée, faire le décompte de la monnaie rendue en partant des pièces de montants les plus élevés. 

Contrainte : interface ISlot ayant seulement les méthodes suivantes : int coinValue(); int coinCount(); boolean isEmpty();

### Transactions de Monnayeur

Une variante de l'exercice précédent, on instancie ici des transactions, avec une Interface contrainte par les méthodes suivantes : void reservedCount(int); boolean commit(); boolean rollback();

L'idée étant que ces méthodes de l'interface lèvent une exception (TransactionException) si le montant réservé est incorrect (négatif), ou si la transaction a déjà été appliquée (commit / rollback). 

### Remplacement de Switch

Question "Par quoi remplacer un switch dans du code ?" (pour diverse raisons : assurer maintenabilité, lisibilité...), en l'occurence le Design Pattern / Patron de Conception 'Command' ('Strategy' peut fonctionner aussi). La réponse consiste plus dans la façon de faire que dans la dénomination. 

## Quelques autres Coding Games vus

Dans le même ordre d'idée que le CyberFizzBuzz : l'objectif est ici de mesurer la réflexion et éventuellement de connaître la rapidité de résolution de l'exercice, mais surtout de voir le degré de connaissance du langage de programmation par la personne qui passe le test. 

### Liste de températures proches de zéro. 

Dans cet exercice, il faut analyser des données de températures (positives et négatives), afin de trouver la plus proche de zéro dans un tableau de valeurs. 

Si le tableau est vide, on renvoie 0. (NOTE : le tableau existe toujours / le tableau n'est jamais 'null'. ). 

Si deux valeurs on la même valeur absolue, on renvoie la valeur positive. 

Dans un contexte java, il s'agit de compléter la méthode suivante : 

```
static double closestToZero(double[] ts) {
	// TODO completion here !!
}

```


### Réorganisation d'un stock par un bras mécanique

L'objectif est de réorganiser des piles de boites avec un bras mécanique, dans une fabrique, et de faire des piles de hauteur égales. Toutes les boites sont sur un certains nombre de piles. Il faut obtenir un nombre égal de boites sur les piles, sinon les boites en excès doivent être empilées de gauche à droite. 

La méthode à implémenter va recevoir régulièrement le status actuel du bras robotique (sa position), le nombre de boites dans chaque pile (un tableau) et si le bras tient une boite. 

Cette méthode doit retourner une commande par tout parmi les suivantes, jusqu'à ce que les boites soient correctement pisitionnées (au lieux en moins de 200 executions) : 

* RIGHT : déplacement du bras robotique d'une pile vers la  __droite__  ; 
* LEFT : déplacement du bras robotique d'une pile vers la  __gauche__  ; 
* PICK : le bras robotique va  __prendre__  une boite dans la pile directement en dessous ; 
* PLACE : le bras robotique va  __poser__  une boite dans la pile directement en dessous ; 

```

static String solve(int clawPos, int[] boxes, boolean boxInClaw) {
	// TODO completion here !!
	return "";
}

```

NOTE sur les notions attendues ici : énumération, ...

Cas de tests : 
* Cas simple ; 
* Un dans chaque ; 
* Quelques dans chaque ; 
* Répartition aléatoire ; 
* ... 

### "RPG Cards" : jeu de cartes de sortilèges contre montre

On soumet un ensemble de cartes définissant des dommages appliqués à un monstre, chaque carte a un coût en 'mana' et définit un type d'effet, des dommages ou des multiplicateurs. 

Comme pour les autres exercices, l'objectif n'est pas de donner une solution, mais d'expliquer la démarche. 

Élements attendus de la part du candidat qui fait l'exercice (idéalement en direct et en un temps limité) : 
  * Mise en place de tests ; 
  * Combinatoire de tests ; 
  * Conceptualisation et représentation objet ; 
  * Optimisation de la pile de cartes (tri) ; 
  * Gestion des instances d'objets (listes, sets...)
  * ... 

## Configuration Projet

Eclipse
Java 8
Méthode 'main' dans chaque exemple (3) pour le 'CyberFizzBuzz'. 
Méthode 'main' dans package dédié pour les "machines à sous". 

## Quelques liens sur le sujet CyberFizzBuzz (et la réflexion qui va avec, à propos de ce fameux test de recrutement en programmation / informatique)

  * ["CyberFizzBuzz"](https://www.sstic.org/media/SSTIC2016/SSTIC-actes/fizzbuzz_cyber/SSTIC2016-Article-fizzbuzz_cyber-jaeger_levillain_kDY1GGu.pdf)
  * [Cyber FizzBuzz : réflexion sur la sélection de candidats dans le
domaine de la SSI (PDF article)](https://ressi2018.sciencesconf.org/187155/document)
  * [Cyber FizzBuzz: réflexion sur la sélection de candidats
dans le domaine de la SSI (PDF slides)](https://paperstreet.picty.org/yeye/resources/conf-ressi-JaegerLL18/slides.pdf)
  * [Coding Dojo : Fizz Buzz (Kata)](http://codingdojo.org/kata/FizzBuzz/)
  * [Cyber FizzBuzz : réflexion sur la sélection de candidats dans le domaine de la SSI](https://paperstreet.picty.org/yeye/2018/conf-ressi-JaegerLL18/)

```
Cyber FizzBuzz : réflexion sur la sélection de candidats dans le domaine de la SSI

Entrée en langue française / French entry Catégorie: Conférence Auteurs: Éric Jaeger, Olivier Levillain et Christian Lixi
Date: 23 mai 2018

Pour le recrutement, il est utile de disposer de questions standards permettant d'apprécier rapidement l'aptitude des candidats à appréhender divers sujets et approches. Nous présentons dans cet article le processus de sélection des candidats à une formation technique en SSI -- des questions parfois éloignées du coeur du sujet, mais dont nous justifions la pertinence.

Présenté lors de la conférence RESSI à Nancy, France le 23 mai 2018
```

## Quelques sites de tests de code / programmation

  * https://www.codingame.com/
  * https://codingdojo.org/
  * https://devskiller.com/fr/coding-tests/


