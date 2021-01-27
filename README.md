# suiviAffaireBackEnd

Bienvenue sur la partie BackEnd de l'application Suivi des Affaires

## Installation

Depuis IntelliJ, importez le projet depuis GitHub

Pour la partie FrontEnd, rendez-vous sur le repo [suiviAffaireFrontEnd](https://github.com/SebFlatBeat/suiviAffaireFrontEnd) et installez-le également

## Tests d'intégration

Pour lancer les tests d'intégration en CLI, il faut installer dans le dossier du projet l'outil developpé par Postman appelé Newman.

Il faut donc faire dans le terminal la commande suivante :

```
npm install -g newman
```

ensuite faites la commande suivante pour executer les tests :
```
 newman run IntegrationTest.postman_collection.json
```

## License
[ENEDIS](https://www.enedis.fr)
