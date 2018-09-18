
public class Warteliste
{
    private Patient[] liste;
    private int maxAnzahl = 10;
    private int anzahl = 0;

    public Warteliste()
    {
        liste = new Patient[maxAnzahl];
    }

    public Patient[] getListe()
    {
        return liste;
    }

    public void einfuegen(Patient pat)
    {
        if (anzahl < maxAnzahl)
        {
            liste[anzahl] = pat;
            anzahl++;
        }
    }

    public Patient aufrufen()
    {
        Patient pat = liste[0];
        for (int i = 0; i < anzahl; i++)
        {
            liste[i] = liste[i+1];
        }
        liste[anzahl] = null;
        anzahl--;
        return pat;
    }

    public int getAnzahl()
    {
        return anzahl;
    }

    public void loeschen(int index)
    {
        // Löscht den Eintrag an der Stelle index

    }

    public void vorziehen(int index)
    {
        // setzt den Eintrag an der Stelle index an die erste Stelle der Liste.
        // Alle anderen rutschen eine Stelle nach hinten.

    }

}
