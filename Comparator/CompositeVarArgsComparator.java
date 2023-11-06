package Comparator;

import java.util.Comparator;

/**
 * Klasa koja predstavlja kompozitni komparator koji moze da se koristi za
 * poredjenje objekata tipa T. Komparator se koristi tako sto mu se prosledi niz
 * drugih komparatora koji ce tim redom biti korisceni za poredjenje dva
 * elementa u {@code compare} metodi. Ukoliko dva elementa nisu jednaka, porede
 * se po sledecem komparatoru u nizu i tako dok se ne prodje ceo niz ili dok
 * rezultat poredjenja ne bude razlicit od nule (dva elementa nisu jednaka). U
 * tom momentu se petlja prekida i dobija se rezultat.
 * 
 * Komparator se moze jednostavno iskoristiti na sledeci nacin. Recimo da imamo
 * vec tri komparatora koji porede klasu Film po ID-ju, reditelju i nazivu i
 * zovu se {@code KomparatorPoID}, {@code KomparatorPoReditelju}
 * i {@code KomparatorPoNazivu} tim redom. U tim komparatorima je vec
 * implementirano poredjenje po navedenim poljima, ali mi bismo sada hteli da
 * "kompozitujemo" te komparatore kako bismo dobili neka nova proizvolja
 * poredjenja. Recimo da zelimo da poredimo filmove po reditelju, pa po nazivu,
 * pa po ID-ju. To mozemo da uradimo na sledeci nacin:
 * 
 * <pre>
 * Comparator<Film> komp = new CompositeVarArgsComparator<>(
 *     new KomparatorPoReditelju(),
 *     new KomparatorPoNazivu(),
 *     new KomparatorPoID());
 * </pre>
 * 
 * @param <T> tip elemenata koje poredimo (ovo ce u sustini biti klasa koju
 *            napravite za skladistenje podataka)
 * @author Dušan Simić <dusan.simic@dmi.uns.ac.rs>
 * @see java.util.Comparator
 */
public class CompositeVarArgsComparator<T> implements Comparator<T> {
  Comparator<T>[] cs;

  /**
   * Konstruktor koji prima niz komparatora.
   * 
   * @param cs niz komparatora
   */
  @SafeVarargs
  public CompositeVarArgsComparator(Comparator<T>... cs) {
    // U konstruktoru primamo niz komparatora i smestamo ih u polje.
    this.cs = cs;
  }

  @Override
  public int compare(T o1, T o2) {
    int result = 0;
    for (Comparator<T> c : cs) {
      result = c.compare(o1, o2);
      // U ovom slucaju je u redu koristiti break zato sto je petlja izuzetno
      // jednostavna. Sigurni smo da zelimo da izadjemo iz nje cim rezultat poredjenja
      // naznaci da dva elementa koja se porede nisu jednaka.
      if (result != 0) {
        break;
      }
    }
    return result;
  }
}
