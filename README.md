# Daily_Active_Users
time complexity : O(n) -
read from file and insert to hash set O(n) (O(1) for ine insertion nd there is n rows in file)
iterate the hashSet O(n) and put into a map O(n). all of this is 0(3n) = O(n)

space complexity : O(n) - HashSet space O(n), HashMap space 0(n) = O(2n) = O(n)

Flow: I separated the reader and the Counter in case we wanted to add a counter or reader with a different logic.
The counter get reader, read the data and analyze it.
