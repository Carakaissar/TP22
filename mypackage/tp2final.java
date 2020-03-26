package mypackage;
import mypackage.*;
import java.io.*;

public class tp2final {
    public static final String PRESENTATION = "Ce programme permet de construire et modifier un horaire de cours.";
    public static final String MENU = "----" + "\nMENU" + "\n----\n"
            + "1. AJOUTER UN COURS A L'HORAIRE  \n2. SUPPRIMER UN COURS A L'HORAIRE \n3. VISUALISER L'HORAIRE "
            + "\n4. EFFACER TOUS LES COURS A L'HORAIRE" + "\n5. QUITTER LE PROGRAMME";
    public static final String AJOUTCOURS = "\nAJOUTER UN COURS A L'HORAIRE\n";
    public static final String SUPPRESIONCOURS = "\nSUPPRIMER UN COURS A L'HORAIRE\n";
    public static final String HORAIRE = "\nHORAIRE\n";
    public static final String SUPPRESIONTOTAL = "\nEFFACER TOUS LES COURS A L'HORAIRE\n";
    public static final String GROUPE = "Groupe du cours : ";
    public static final String FIN = "\n\nFIN NORMALE DU PROGRAMME.\n";
    public static final String ENTREE = "Appuyez sur \"ENTREE\" pour continuer...";
    public static final String OUINON = "Repondez par OUI ou par NON...";
    public static final String OPANNULER = "OPERATION ANNULEE.\n";
    public static final String LABOEXISTANT = "Il existe deja un cours (ou laboratoire) dans la plage horaire : ";
    public static final String REMISEAZERO = "Voulez-vous vraiment supprimer tous les cours de cet horaire"
            + " (OUI ou NON) ? ";

    /**
     * Affiche une breve presentation du programme
     */
    public static void presentation() {
        System.out.println(PRESENTATION);
    }

    /**
     * Affiche une breve presentation du menu.
     */
    public static void affichermenu() {
        System.out.print(MENU);
    }

    /**
     * Affiche un message d'erreur
     */
    public static void erreur(String a, String b) {

        System.out.print("Erreur,le" + a + "doit etre " + b + "...");

    }

    /**
     * * Cette methode saisit et valide le choix de l'utilisateur * entre borneInf
     * et borneSup. * @param msgSoll le message de sollicitation pour le choix * de
     * l'utilisateur. * @param msgErr le message d'erreur lorsqu'un choix est *
     * invalide. * @return le choix valide de l'utilisateur, entre * borneInf et
     * borneSup.
     */
    public static String validerChoixMenu(String msgSoll, String msgErr) {
        String choixMenu = null;
        System.out.print("\n" + msgSoll);
        choixMenu = Clavier.lireString();
        while (!choixMenu.equals("1") && !choixMenu.equals("2") && !choixMenu.equals("3") && !choixMenu.equals("4")
                && !choixMenu.equals("5")) {
            System.out.println(msgErr);
            affichermenu();
            System.out.print(msgSoll);
            choixMenu = Clavier.lireString();
        }
        return choixMenu;
    }

    /**
     * affichage du titres apres choix du menu
     */
    public static void titres(String nbr) {
        switch (nbr) {
            case "1":
                System.out.print("****************************");
                System.out.print(AJOUTCOURS);
                System.out.print("****************************\n");
                break;
            case "2":
                System.out.print("******************************");
                System.out.print(SUPPRESIONCOURS);
                System.out.print("******************************\n");
                break;
            case "3":
                System.out.print("*******");
                System.out.print(HORAIRE);
                System.out.print("*******\n");
                break;
            case "4":
                System.out.print("**********************************");
                System.out.print(SUPPRESIONTOTAL);
                System.out.print("**********************************\n");
                break;
        }

    }

    /**
     * validation de la sigle rentre
     * 
     */
    public static String sigle() {
        String choixoption = null;
        do {
            System.out.print("\nSigle du cours :");
            choixoption = Clavier.lireString();
            if (choixoption.length() != 7 || !Character.isLetter(choixoption.charAt(0))
                    || !Character.isLetter(choixoption.toUpperCase().charAt(1))
                    || !Character.isLetter(choixoption.toUpperCase().charAt(2))
                    || !Character.isDigit(choixoption.toUpperCase().charAt(3))
                    || !Character.isDigit(choixoption.charAt(4)) || !Character.isDigit(choixoption.charAt(5))
                    || !Character.isDigit(choixoption.charAt(6))) {
                erreur(" sigle du cours ", "compose de 3 lettres suivies de 4 chiffres");
            }
        } while ((choixoption.length() != 7 || !Character.isLetter(choixoption.charAt(0))
                || !Character.isLetter(choixoption.toUpperCase().charAt(1))
                || !Character.isLetter(choixoption.toUpperCase().charAt(2))
                || !Character.isDigit(choixoption.toUpperCase().charAt(3)) || !Character.isDigit(choixoption.charAt(4))
                || !Character.isDigit(choixoption.charAt(5)) || !Character.isDigit(choixoption.charAt(6))));
        choixoption = choixoption.toUpperCase();
        return choixoption;
    }

    /**
     * annalyse du jour
     */
    public static String jourdu(String a) {
        String jour = null;
        do {
            System.out.print("Jour du " + a);
            jour = Clavier.lireString();
            jour = jour.toLowerCase();
            if (!(jour.equals("lundi") || jour.equals("mardi") || jour.equals("mercredi") || jour.equals("jeudi")
                    || jour.equals("vendredi"))) {
                erreur("jour", "lundi,mardi,mercredi,jeudi ou vendredi");
            }

        } while (!(jour.equals("lundi") || jour.equals("mardi") || jour.equals("mercredi") || jour.equals("jeudi")
                || jour.equals("vendredi")));
        jour = jour.toUpperCase();
        return jour;
    }

    /**
     * annalyse le moment du jour
     * 
     * @return
     */
    public static String momentdujour(String a) {
        String moment = null;
        do {
            System.out.print("Moment du jour de ce " + a);
            moment = Clavier.lireString();
            if (!(moment.equalsIgnoreCase("am") || moment.equalsIgnoreCase("pm") || moment.equalsIgnoreCase("soir"))) {
                erreur("moment du jour", "am, pm, ou soir");
            }

        } while (!(moment.equalsIgnoreCase("am") || moment.equalsIgnoreCase("pm") || moment.equalsIgnoreCase("soir")));
        return moment;
    }

    /**
     * annalyse de choix du groupe
     */
    public static String bongroupe(String a) {
        boolean verif;
        String groupe = null;
        do {
            verif = false;
            System.out.print(GROUPE);
            groupe = Clavier.lireString();
            if (groupe.length() != 2 || !Character.isDigit(groupe.charAt(0)) || !Character.isDigit(groupe.charAt(1))) {
                System.out.print("a");
                verif = true;
            } else if (a.equalsIgnoreCase("lundi") & (groupe.charAt(0) != '1')) {
                System.out.print("b");
                verif = true;
            } else if (a.equalsIgnoreCase("mardi") & (groupe.charAt(0) != '2')) {
                System.out.print("c");
                verif = true;
            } else if (a.equalsIgnoreCase("mercredi") & (groupe.charAt(0) != '3')) {
                System.out.print("d");
                verif = true;
            } else if (a.equalsIgnoreCase("jeudi") & (groupe.charAt(0) != '4')) {
                System.out.print("e");
                verif = true;
            } else if (a.equalsIgnoreCase("vendredi") & (groupe.charAt(0) != '5')) {
                verif = true;

            }

        } while (verif);
        return groupe;
    }

    /**
     * message fin
     */
    public static void fin() {
        System.out.print(FIN);
    }

    /**
     * Provoque l'arret du programme et demande d'entrer un ENTER pour continuer.
     */
    public static void pause() {
        System.out.print(ENTREE);
        Clavier.lireFinLigne();
        System.out.println("\n");
    }

    /**
     * programme demande a l'utilisateur de rentre "oui" ou "non"
     *
     */
    public static String ouinon(String a) {
        String ouinon = null;
        String oui = "oui";
        String non = "non";
        do {
            System.out.print(a);
            ouinon = Clavier.lireString();
            if (!oui.equalsIgnoreCase(ouinon) && !non.equalsIgnoreCase(ouinon)) {
                System.out.print(OUINON);
            }
        } while (!oui.equalsIgnoreCase(ouinon) && !non.equalsIgnoreCase(ouinon));
        return ouinon;
    }

    /**
     * message d'annulation
     */
    public static void annulation(String a) {
        System.out.print(OPANNULER);
        System.out.println(a);
        pause();
    }

    public static void plagehoraireinvalide(String a, String b) {
        System.out.print(OPANNULER);
        System.out.println(LABOEXISTANT + a + b);
        pause();
    }

    /**
     * TABLEAUHORAIRE
     */
    public static void tableauhoraire() {
      
       
        System.out.println("===============================================================================");
        System.out.printf("|%-12S|%-21S|%-21S|%-20S|\n", "", " MATIN", " APRES-MIDI", " SOIREE");
        System.out.println("===============================================================================");
        System.out.printf("|%-12S|%-21S|%-21S|%-20S|\n", "LUNDI",  s , "", "");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%-12S|%-21S|%-21S|%-20S|\n", "MARDI", "" , "", "");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%-12S|%-21S|%-21S|%-20S|\n", "MERCREDI", "", "", "");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%-12S|%-21S|%-21S|%-20S|\n", "JEUDI", " ", " ", " ");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%-12S|%-21S|%-21S|%-20S|\n", "VENDREDI", " ", " ", " ");
        System.out.println("================================================================================");

        pause();

    }

    /**
     * message horaire vide
     */
    public static boolean horairevide(String a) {
        boolean videoupas;
        videoupas = a.isEmpty();
        return videoupas;
    }

    public static boolean comparaison(String a, String b) {
        boolean option;
        option = a.contains(b);
        return option;
    }

    public static String effacercours(String a, String b) {
        String testhoraire = b;
        int nouveauhorair;
        int prochainc;
        String remplacement;
        nouveauhorair = b.indexOf(a);
        prochainc = b.indexOf("C", nouveauhorair);
        if (prochainc != -1) {
            remplacement = b.substring(nouveauhorair - 2, prochainc);
        } else {
            remplacement = b.substring(nouveauhorair - 2);

        }
        testhoraire = b.replace(remplacement, "");
        return testhoraire;
    }

    public static boolean plage(String a, String b, String c) {
        boolean plage1;
        plage1 = c.contains(a + "|" + b);
        return plage1;
    }

    public static void ajouttercourhoraire(String a, String b , String c) {
        
    }

    public static void main(String[] args) {

        String horaire = "";
        String choix;
        String sigle = "";
        String jour = "";
        String moment = "";
        String groupe = "";
        String optionLaboratoire = "";
        String oui = "oui";
        String non = "non";
        String jourlabo = "";
        String momentlabo = "";
        boolean compa;
        boolean compa1;
        boolean plagehoraire;
        boolean horairevideoupas;
        String optionsuppresion = "";
        String ajoutCour = "" ;

        presentation();

        do {

            affichermenu();
            choix = validerChoixMenu("\n\nENTREZ VOTRE CHOIX : ",
                    "\nErreur, entrez une valeur entre 1 et 5 " + " ... Recommencez.\n");

            // TRAITEMENT OPTION 1
            switch (choix) {
                case "1":
                    titres(choix);
                    sigle = sigle();
                    compa = comparaison(horaire, sigle);
                    if (compa) {
                        annulation("Ce cours ne peut etre ajoute car il est deja present dans votre horaire. ");
                    } else {
                        jour = jourdu("cours");
                        moment = momentdujour("cours");
                        groupe = bongroupe(jour);
                        
                        plagehoraire = plage(jour, moment, horaire);
                        if (plagehoraire) {
                            plagehoraireinvalide(jour, moment);
                        } else if (!plagehoraire) {
                            optionLaboratoire = ouinon("Ce cours comprend-il une periode de laboratoire(oui ou non)");
                            if (optionLaboratoire.equalsIgnoreCase(oui)) {
                                jourlabo = jourdu("laboratoire");
                                momentlabo = momentdujour("laboratoire");
                                plagehoraire = plage(jourlabo, momentlabo, horaire);
                                if (!plagehoraire) {
                                    horaire = horaire + "C" + "|" + sigle + "|" + groupe + "|" + jour + "|" + moment
                                            + "\n";
                                    horaire = horaire + "L" + "|" + sigle + "|" + groupe + "|" + jourlabo + "|"
                                            + momentlabo + "\n";
                                } else if (plagehoraire) {
                                    plagehoraireinvalide(jour, moment);
                                }
                            } else if (optionLaboratoire.equalsIgnoreCase(non)) {
                                horaire = horaire + "C" + "|" + sigle + "|" + groupe + "|" + jour + "|" + moment + "\n";
                            }
                            System.out.print(horaire);
                        }
                    }
                    break;
                case "2":
                    titres(choix);
                    horairevideoupas = horairevide(horaire);
                    if (horairevideoupas) {
                        annulation("L'horaire ne contient aucun cours. ");
                    } else {
                        sigle = sigle();
                        compa1 = comparaison(horaire, sigle);
                        if (compa1) {
                            horaire = effacercours(sigle, horaire);
                            System.out.print(horaire);
                        } else {
                            annulation("Ce cours n'est pas a l'horaire. ");
                        }
                    }
                    break;
                case "3":
                    titres(choix);
                    tableauhoraire();
                    // pause();
                    break;
                case "4":
                    titres(choix);
                    horairevideoupas = horairevide(horaire);
                    if (horairevideoupas) {
                        annulation("L'horaire ne contient aucun cours. ");
                    } else {
                        optionsuppresion = ouinon(REMISEAZERO);
                        if (optionsuppresion.equalsIgnoreCase(oui)) {
                            horaire = "";
                        } else if (optionsuppresion.equalsIgnoreCase(non)) {
                            annulation("");
                        }
                    }
                    break;
            }

        } while (!choix.equals("5"));
        fin();
    }
}
