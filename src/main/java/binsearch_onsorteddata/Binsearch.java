package binsearch_onsorteddata;

/**
 *
 *
 * Algorithm design manual p133
 * Created by gs on 2016-05-25.
 */
public class Binsearch {

//    COunting occrences

//    if (s[middle] == key) return(middle);
//    from the implementation above and return the index low instead of −1 on each
//    unsuccessful search. All searches will now be unsuccessful, since there is no equality
//    test. The search will proceed to the right half whenever the key is compared to an
//    identical array element, eventually terminating at the right boundary. Repeating
//    the search after reversing the direction of the binary comparison will lead us to the
//    left boundary. Each search takes O(lg n) time, so we can count the occurrences in
//    logarithmic time regardless of the size of the block.
//    int binary_search(item_type s[], item_type key, int low, int high)
//    {
//        int middle; /* index of middle element */
//        if (low > high) return (-1); /* key not found */
//        middle = (low+high)/2;
//        3It is actually quite interesting serving as an expert witness.
//        4.9 BINARY SEARCH AND RELATED ALGORITHMS 133
//        if (s[middle] == key) return(middle);
//        if (s[middle] > key)
//            return( binary_search(s,key,low,middle-1) );
//        else
//            return(binary_search(s,key,middle+1,high) );
//    }
//    This
}
