package Comparator;

import java.util.Comparator;

/**
 * Klasa koja predstavlja kompozitni komparator koji moze da se koristi za
 * poredjenje objekata tipa T. Komparator se koristi tako sto se konstruktoru
 * proslede dva komparatora koji ce tim redom (prvo komparator iz prvog a zatim
 * onaj iz drugog parametra) biti korisceni za poredjenje dva elementa u
 * {@code compare} metodi. Ukoliko dva elementa nisu razlicita po prvom
 * komparatoru (rezultat poredjenja je broj {@code 0}), porede se po drugom
 * komparatoru.
 * 
 * Komparator se moze jednostavno koristiti na sledeci nacin. Recimo da imamo
 * vec tri komparatora koji porede klasu Film po ID-ju, reditelju i nazivu i
 * zovu se {@code KomparatorPoID}, {@code KomparatorPoReditelju} i
 * {@code KomparatorPoNazivu} tim redom. U tim komparatorima je vec
 * implementirano poredjenje po navedenim poljima, ali mi bismo sada hteli da
 * "kompozitujemo" te komparatore kako bismo dobili neka nova proizvolja
 * poredjenja. Recimo da zelimo da poredimo filmove po reditelju, pa po nazivu,
 * pa po ID-ju. To mozemo da uradimo na sledeci nacin:
 * 
 * <pre>
 * Comparator<Film> kompPoRediNaz = new CompositeComparator<>(
 *     new KomparatorPoReditelju(),
 *     new KomparatorPoNazivu());
 * 
 * Comparator<Film> komp = new CompositeComparator<>(
 *     kompPoRediNaz,
 *     new KomparatorPoID());
 * </pre>
 * 
 * Kao sto se moze videti u datom kodu, komparator smo morali praviti iz dve
 * iteracije. U prvoj smo napravili komparator koji poredi po reditelju a zatim
 * po nazivu, a u drugoj smo napravili komparator koji koristi prvi (poredi po
 * reditelju i nazivu) i preostali komparator koji poredi po ID-ju. Sigurni smo
 * da ce se prvo porediti po reditelju i nazivu, a zatim po ID-ju zato sto je to
 * redosled u kom smo ih prosledili konstruktoru.
 * 
 * Moguce je ukoliko je potrebno dodati i nove parametre u konstruktoru i nova
 * polja klase kako bismo dobili vise komparatora po kojima se moze porediti i
 * "kompozitovati" novi komparator. Naime, to moze da bude problematicno ukoliko
 * nam je potreban veliki broj komparatora po kojima se poredi. Za tu namenu je
 * bolji {@link CompositeVarArgsComparator}.
 * 
 * @param <T> tip elemenata koje poredimo (ovo ce u sustini biti klasa koju
 *            napravite za skladistenje podataka)
 * @author Dušan Simić <dusan.simic@dmi.uns.ac.rs>
 * @see java.util.Comparator
 * @see CompositeVarArgsComparator
 */
public class CompositeComparator<T> implements Comparator<T> {
  Comparator<T> c1;
  Comparator<T> c2;

  public CompositeComparator(Comparator<T> c1, Comparator<T> c2) {
    this.c1 = c1;
    this.c2 = c2;
  }

  @Override
  public int compare(T o1, T o2) {
    int result = c1.compare(o1, o2);
    if (result == 0) {
      result = c2.compare(o1, o2);
    }
    return result;
  }
}
