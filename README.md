# 🕵️‍♂️ Jeu du pendu en Java
Ce projet Java propose un petit jeu en console où le joueur doit deviner un mot mystère, lettre par lettre, avec un nombre limité d’essais (10 par défaut)
---
### 📁 Méthodes clés :
- **randomizer()** : sélectionne un mot aléatoire dans une liste donnée
- **hidingWordFromUser()** : masque le mot à trouver avec des underscore '_ _ _ _'
- **displayHidenWord()** : affichage du mot masqué
- **updatingHiddenWord()** : sert à révèler les lettres déja trouvées
-  **winCondition()** : vérifie si le mot est entièrement découvert
---
### 🎮 Fonctionnement du jeu
1. Un mot est choisi aléatoirement parmi une liste prédéfinie
2. Le mot est affiché sous forme masquée (_ _ _ _ _)
3. Le joueur propose une lettre à chaque tour
4. Si la lettre est correcte, elle est révélée dans le mot
5. Si elle est incorrecte, le nombre d’essais restants diminue
6. Le joueur gagne s’il découvre le mot avant d’avoir épuisé ses 10 essais
---
### 🚀 Pour exécuter le projet
1. Compiler le fichier:

           javac Main.java
2. Lancer le programme:

          java fr.ex.tp3.Main
---
### 📦 Dépendances
Ce projet utilise uniquement les bibliothèques standards de Java :
- **java.util.*** pour les collections et le générateur aléatoire
- **java.util.Scanner** pour la saisie utilisateur
   
