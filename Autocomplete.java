import java.util.Arrays;

public class Autocomplete {
    private Term[] terms;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        // Create a local copy of the terms array, so it can't be modified from outside
        this.terms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            this.terms[i] = terms[i];
        }

        // Sort the terms lexicographically
        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        // Create a Term with the prefix for binary search
        Term prefixTerm = new Term(prefix, 0);

        // Find the range of terms that start with the prefix
        int first = BinarySearchDeluxe.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));

        // If no matches, return an empty array
        if (first == -1) {
            return new Term[0];
        }

        // Create an array to hold the matching terms
        int count = last - first + 1;
        Term[] matches = new Term[count];

        // Copy matching terms to the result array
        for (int i = 0; i < count; i++) {
            matches[i] = terms[first + i];
        }

        // Sort matching terms by weight in descending order
        Arrays.sort(matches, Term.byReverseWeightOrder());

        return matches;    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        // Create a Term with the prefix and 0 weight for binary search
        Term prefixTerm = new Term(prefix, 0);

        // Find the range of terms that start with the prefix
        int first = BinarySearchDeluxe.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));

        // If first is -1, no matches were found
        if (first == -1) {
            return 0;
        }

        // Return the count of matches
        return last - first + 1;
    }
    

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}