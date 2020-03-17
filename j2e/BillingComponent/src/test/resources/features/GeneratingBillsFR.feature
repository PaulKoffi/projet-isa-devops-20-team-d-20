#language: fr

  Fonctionnalité: Générer des factures
    Contexte: un employé s'occupe des livraisons un autre s'occupe des factures


      Scénario: Il n'y a pas de livraisons à faire
        Quand l'employé demande la prochaine livraison
        Alors il y 0 livraisons
        Et donc il y a 0 facture

      Scénario: Il y a plusieurs livraisons à faire d'un seul fournisseur
        Quand l'employé effectue les 2 prochaines livraisons
        Alors il y 1 facture