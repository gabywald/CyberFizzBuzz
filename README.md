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

## Autres tests ("Machines à Sous")

Tests pour éprouver les connaissances sur usage des Interfaces, des patrons de conception (Design Patterns) et des différents niveaux d'accessibilité. 

Façon de voir et vérifier la façon de coder en général. 

Il existe aussi des variantes en algorithmie (façon de décompter la monnaie, trier les instances d'objets...), un exercice de style. 

### Monnayeur / ChangeMachine / SlotMachine

Sur une machine composée de 'slots' contenant des pièces : à partir d'un montant donné en entrée, faire le décompte de la monnaie rendue en partant des pièces de montants les plus élevés. 

Contrainte : interface ISlot ayant seulement les méthodes suivantes : int coinValue(); int coinCount(); boolean isEmpty();

### Transactions de Monnayeur

Une variante de l'exercice précédent, on instancie ici des transactions, avec une Interface contrainte par les méthodes suivantes : void reservedCount(int); boolean commit(); boolean rollback();

L'idée étant que ces méthodes de l'interface lèvent une exception (TransactionException) si le montant réservé est incorrect (négatif), ou si la transaction a déjà été appliquée (commit / rollback). 

## Configuration Projet

Eclipse
Java 8
Méthode 'main' dans chaque exemple (3) pour le 'CyberFizzBuzz'. 
Méthode 'main' dans package dédié pour les "machines à sous". 

## Quelques liens sur le sujet CyberFizzBuzz (et la réflexion qui va avec, à propos de ce fameux test de recrutement en programmation / informatique)

https://paperstreet.picty.org/yeye/2018/conf-ressi-JaegerLL18/ --

> Cyber FizzBuzz : réflexion sur la sélection de candidats dans le domaine de la SSI

>Entrée en langue française / French entry Catégorie: Conférence Auteurs: Éric Jaeger, Olivier Levillain et Christian Lixi
>Date: 23 mai 2018

>Pour le recrutement, il est utile de disposer de questions standards permettant d'apprécier rapidement l'aptitude des candidats à appréhender divers sujets et approches. Nous présentons dans cet article le processus de sélection des candidats à une formation technique en SSI -- des questions parfois éloignées du coeur du sujet, mais dont nous justifions la pertinence.

>Présenté lors de la conférence RESSI à Nancy, France le 23 mai 2018
>BibTeX Document Présentation

https://www.sstic.org/media/SSTIC2016/SSTIC-actes/fizzbuzz_cyber/SSTIC2016-Article-fizzbuzz_cyber-jaeger_levillain_kDY1GGu.pdf

https://ressi2018.sciencesconf.org/187155/document --

https://paperstreet.picty.org/yeye/resources/conf-ressi-JaegerLL18/slides.pdf

http://codingdojo.org/kata/FizzBuzz/ --
