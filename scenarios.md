# Scenarios
    Etat Initiale du système : VIDE
    LE SERVEUR J2E EST UP
    LE SERVEUR MONO EST UP
#  Enregistrer 2 transporteurs "AMAZON" et "ADIDAS" dans la base qui viennent de livrer des colis
    registerProvider AMAZON
    registerProvider ADIDAS
#  Enregistrer ensuite les colis que ces 2 fournisseurs ont livrer , le colis SD15 pèse 5kg...
    registerPackage SD15 AMAZON 5 05/05/2020 10h00
    registerPackage XKXK AMAZON 10 05/05/2020 10h01
#  Rechercher un client "koffi paul" qui vient de nous appeler pour programmer une livraison
    findCustomer koffi paul
#  Enregistrer le client koffi paul habitant à 3 Rue Soutrane qui n'existe pas encore dans notre BD
    registerCustomer koffi paul 3 rue soutrane
#  Rechercher le client "koffi paul" à nouveau
    findCustomer koffi paul
#  Rechercher le colis via son numéro secret qui nous est fourni par le client
    findPackage SD16
#  Le client s"est tromper de numéro et nous redonne le bon : SD15, le colis est trouvé
    findPackage SD15
#  Le client décide de programmer sa livraison pour le 20/08/2020 à 15h00
    registerDelivery koffi paul SD15 20/08/2020 15h00
#  Verifier que la livraison du client a bien été programmé 
    findDeliveryByD 20/08/2020
#  On vérifie s'il y'a une prochaine livraison de colis à un client 
    nextDelivery
#  Il y'a 3 nouveaux drones qu'on a acheter
    registerDrone DR01 10/05/2020 10h00
    registerDrone DR02 07/05/2020 10h00
    registerDrone DR03 05/05/2020 10h00
#  Le client "Oscar Cesar" appelle pour programmer une livraison et nous dit directement que c"est sa première livraison,on l'enregistre donc
    registerCustomer Oscar Cesar 3 rue des beaux Gosses
#  Le numéro secret de son colis est XKXK et il veut une livraison pour aujourd'hui à 12h00
    registerDelivery Oscar Cesar XKXK TODAY 12h00
#  Le client "paul koffi" vient d'appeler et veut reprogrammer la livraison de son colis aujourd'hui à 12h30
    reprogrammingDelivery 20/08/2020 15h00 TODAY 12h30
#  L'enregistrement échoue et paul demande si c'est possible de se faire livrer à 13h00 ou 13h30
    validSlot TODAY 13h00
    validSlot TODAY 13h30
#  Paul décide de se faire livrer à 13h30 alors
    reprogrammingDelivery 20/08/2020 15h00 TODAY 13h30
#  Vérifier la liste des livraisons de la journée, on voit bien les 2 livraisons
    findDeliveryByD TODAY
#  Lancer les prochaines livraisons
    nextDelivery
    nextDelivery
    nextDelivery
#  Enregistrer le colis VTMM du fournisseur NIKE
    registerPackage VTMM NIKE 8 TODAY 14h00
# Le fournisseur NIKE n'est pas encore enrégistré , on l'enrégistre avant de continuer
    registerProvider NIKE
    registerPackage VTMM NIKE 8 TODAY 14h00
# Le client paul koffi appelle à nouveau pour une nouvelle livraison et donne le numéro du colis VTMM
    registerDelivery koffi paul SD15 20/13/2020 16h00
# L'intercepteur s'est déclencher précedemment car la date avait un mauvais format  20/13/2020
    registerDelivery koff paul SD15 20/12/2020 16h00
# Cette fois ci , on s"est tromper dans le nom du client , on reesaye en corrigeant
    registerDelivery koffi paul VTM 20/12/2020 16h00
# Le nom du client est correct mais on a fausser le num du colis, paul est énervé et veut être livré aujourd'hui
    registerDelivery koffi paul VTMM TODAY 18h00
# Enfin , c'est passé , on veut maintenant Lancer la prochaine livraison
    nextDelivery
# ça ne passe pas , on a pas de drones disponibles, on enregistre un nouveau drone et on réesaye 
    registerDrone DR04 TODAY 10h00
    nextDelivery
# On est à la fin de la journée et on génère les factures , puis on consulte celles des factures payées
    generate
    getBills
    getPaidBills
# seul les ID de facture 1 et 3 sont présents au niveau du serveur externe
# Le test d'intégration global du système et qui parle aux autres serveurs se trouve dans \integration-tests\IntegrationTestsComponent
# faire un UP des serveurs dans docker ou des serveurs locaux avant de le lancer