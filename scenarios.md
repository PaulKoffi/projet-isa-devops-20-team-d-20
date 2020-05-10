# Scenarios

    Etat Initiale du système : VIDE
    
#  Enregistrer 2 transporteurs "AMAZON" et "ADIDAS" dans la base qui viennent de livrer des colis
    registerProvider AMAZON
    registerProvider ADIDAS
    
#  Enregistrer ensuite les colis que ces 2 fournisseurs ont livrer , le colis SD15 pèse 5kg...
    registerPackage SD15 AMAZON 5 05/05/2020 10h00
    registerPackage XKXK AMAZON 10 05/05/2020 10h01
    registerPackage VEVE ADIDAS 20 05/05/2020 10h02

#  Rechercher un client "koffi paul" qui vient de nous appeler pour programmer une livraison
    findCustomer Koffi paul
   
#  Enregistrer le client koffi paul habitant à 3 Rue Soutrane qui n'existe pas encore dans notre BD
    registerCustomer koffi paul 3 rue soutrane

#  Rechercher le client "koffi paul" à nouveau
    findCustomer Koffi paul
   
#  Rechercher le colis via son numéro secret qui nous est fourni par le client
    findPackage SD16
    
#  Le client s"est tromper de numéro et nous redonne le bon : SD15, le colis est trouvé
    findPackage SD15
    
#  Le client décide de programmer sa livraison pour le 20/08/2020 à 15h00
    registerDelivery koffi paul SD15 20/08/2020 15h00


    









# --------- Pour lancer le test d'intégration global du système ------------------