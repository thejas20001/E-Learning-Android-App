package com.learning.elearning.ui.code;

public class ProgramExample {
    public static final String ex1 = "#include <bits/stdc++.h>\n" +
            "using namespace std;\n" +
            "  \n" +
            "// Function to maximize the matching\n" +
            "// pairs between two permutation\n" +
            "// using left and right rotation\n" +
            "int maximumMatchingPairs(int perm1[],\n" +
            "                         int perm2[],\n" +
            "                         int n)\n" +
            "{\n" +
            "    // Left array store distance of element\n" +
            "    // from left side and right array store\n" +
            "    // distance of element from right side\n" +
            "    int left[n], right[n];\n" +
            "  \n" +
            "    // Map to store index of elements\n" +
            "    map<int, int> mp1, mp2;\n" +
            "    for (int i = 0; i < n; i++) {\n" +
            "        mp1[perm1[i]] = i;\n" +
            "    }\n" +
            "    for (int j = 0; j < n; j++) {\n" +
            "        mp2[perm2[j]] = j;\n" +
            "    }\n" +
            "  \n" +
            "    for (int i = 0; i < n; i++) {\n" +
            "  \n" +
            "        // idx1 is index of element\n" +
            "        // in first permutation\n" +
            "  \n" +
            "        // idx2 is index of element\n" +
            "        // in second permutation\n" +
            "        int idx2 = mp2[perm1[i]];\n" +
            "        int idx1 = i;\n" +
            "  \n" +
            "        if (idx1 == idx2) {\n" +
            "  \n" +
            "            // If element if present on same\n" +
            "            // index on both permutations then\n" +
            "            // distance is zero\n" +
            "            left[i] = 0;\n" +
            "            right[i] = 0;\n" +
            "        }\n" +
            "        else if (idx1 < idx2) {\n" +
            "  \n" +
            "            // Calculate distance from left\n" +
            "            // and right side\n" +
            "            left[i] = (n - (idx2 - idx1));\n" +
            "            right[i] = (idx2 - idx1);\n" +
            "        }\n" +
            "        else {\n" +
            "  \n" +
            "            // Calculate distance from left\n" +
            "            // and right side\n" +
            "            left[i] = (idx1 - idx2);\n" +
            "            right[i] = (n - (idx1 - idx2));\n" +
            "        }\n" +
            "    }\n" +
            "  \n" +
            "    // Maps to store frequencies of elements\n" +
            "    // present in left and right arrays\n" +
            "    map<int, int> freq1, freq2;\n" +
            "    for (int i = 0; i < n; i++) {\n" +
            "        freq1[left[i]]++;\n" +
            "        freq2[right[i]]++;\n" +
            "    }\n" +
            "  \n" +
            "    int ans = 0;\n" +
            "  \n" +
            "    for (int i = 0; i < n; i++) {\n" +
            "  \n" +
            "        // Find maximum frequency\n" +
            "        ans = max(ans, max(freq1[left[i]],\n" +
            "                           freq2[right[i]]));\n" +
            "    }\n" +
            "  \n" +
            "    // Return the result\n" +
            "    return ans;\n" +
            "}\n" +
            "  \n" +
            "// Driver Code\n" +
            "int main()\n" +
            "{\n" +
            "    // Given permutations P1 and P2\n" +
            "    int P1[] = { 5, 4, 3, 2, 1 };\n" +
            "    int P2[] = { 1, 2, 3, 4, 5 };\n" +
            "    int n = sizeof(P1) / sizeof(P1[0]);\n" +
            "  \n" +
            "    // Function Call\n" +
            "    cout << maximumMatchingPairs(P1, P2, n);\n" +
            "    return 0;\n" +
            "}";

    public static final String ex2 = "import java.util.*;\n" +
            "class GFG{\n" +
            "  \n" +
            "// Function to maximize the matching\n" +
            "// pairs between two permutation\n" +
            "// using left and right rotation\n" +
            "static int maximumMatchingPairs(int perm1[],\n" +
            "                                int perm2[],\n" +
            "                                int n)\n" +
            "{\n" +
            "  // Left array store distance of element\n" +
            "  // from left side and right array store\n" +
            "  // distance of element from right side\n" +
            "  int []left = new int[n];\n" +
            "  int []right = new int[n];\n" +
            "  \n" +
            "  // Map to store index of elements\n" +
            "  HashMap<Integer,\n" +
            "          Integer> mp1 =  new HashMap<>();\n" +
            "  HashMap<Integer,\n" +
            "          Integer> mp2 =  new HashMap<>();\n" +
            "    \n" +
            "  for (int i = 0; i < n; i++) \n" +
            "  {\n" +
            "    mp1.put(perm1[i], i);\n" +
            "  }\n" +
            "  for (int j = 0; j < n; j++) \n" +
            "  {\n" +
            "    mp2.put(perm2[j], j);\n" +
            "  }\n" +
            "  \n" +
            "  for (int i = 0; i < n; i++) \n" +
            "  {\n" +
            "    // idx1 is index of element\n" +
            "    // in first permutation\n" +
            "    // idx2 is index of element\n" +
            "    // in second permutation\n" +
            "    int idx2 = mp2.get(perm1[i]);\n" +
            "    int idx1 = i;\n" +
            "  \n" +
            "    if (idx1 == idx2) \n" +
            "    {\n" +
            "      // If element if present on same\n" +
            "      // index on both permutations then\n" +
            "      // distance is zero\n" +
            "      left[i] = 0;\n" +
            "      right[i] = 0;\n" +
            "    }\n" +
            "    else if (idx1 < idx2) \n" +
            "    {\n" +
            "      // Calculate distance from left\n" +
            "      // and right side\n" +
            "      left[i] = (n - (idx2 - idx1));\n" +
            "      right[i] = (idx2 - idx1);\n" +
            "    }\n" +
            "    else \n" +
            "    {\n" +
            "      // Calculate distance from left\n" +
            "      // and right side\n" +
            "      left[i] = (idx1 - idx2);\n" +
            "      right[i] = (n - (idx1 - idx2));\n" +
            "    }\n" +
            "  }\n" +
            "  \n" +
            "  // Maps to store frequencies of elements\n" +
            "  // present in left and right arrays\n" +
            "  HashMap<Integer,\n" +
            "          Integer> freq1 = new HashMap<>();\n" +
            "  HashMap<Integer,\n" +
            "          Integer> freq2 = new HashMap<>();\n" +
            "    \n" +
            "  for (int i = 0; i < n; i++) \n" +
            "  {\n" +
            "    if(freq1.containsKey(left[i]))\n" +
            "      freq1.put(left[i], \n" +
            "      freq1.get(left[i]) + 1);\n" +
            "    else\n" +
            "      freq1.put(left[i], 1);\n" +
            "    if(freq2.containsKey(right[i]))\n" +
            "      freq2.put(right[i], \n" +
            "      freq2.get(right[i]) + 1);\n" +
            "    else\n" +
            "      freq2.put(right[i], 1);\n" +
            "  }\n" +
            "  \n" +
            "  int ans = 0;\n" +
            "  \n" +
            "  for (int i = 0; i < n; i++) \n" +
            "  {\n" +
            "    // Find maximum frequency\n" +
            "    ans = Math.max(ans, \n" +
            "          Math.max(freq1.get(left[i]),\n" +
            "                   freq2.get(right[i])));\n" +
            "  }\n" +
            "  \n" +
            "  // Return the result\n" +
            "  return ans;\n" +
            "}\n" +
            "  \n" +
            "// Driver Code\n" +
            "public static void main(String[] args)\n" +
            "{\n" +
            "  // Given permutations P1 and P2\n" +
            "  int P1[] = {5, 4, 3, 2, 1};\n" +
            "  int P2[] = {1, 2, 3, 4, 5};\n" +
            "  int n = P1.length;\n" +
            "  \n" +
            "  // Function Call\n" +
            "  System.out.print(maximumMatchingPairs(P1, P2, n));\n" +
            "}\n" +
            "}";

    public static final String ex3 ="# Python3 program for the above approach\n" +
            "from collections import defaultdict\n" +
            "\n" +
            "# Function to maximize the matching\n" +
            "# pairs between two permutation\n" +
            "# using left and right rotation\n" +
            "def maximumMatchingPairs(perm1, perm2, n):\n" +
            "\n" +
            "\t# Left array store distance of element\n" +
            "\t# from left side and right array store\n" +
            "\t# distance of element from right side\n" +
            "\tleft = [0] * n\n" +
            "\tright = [0] * n\n" +
            "\n" +
            "\t# Map to store index of elements\n" +
            "\tmp1 = {}\n" +
            "\tmp2 = {}\n" +
            "\tfor i in range (n):\n" +
            "\t\tmp1[perm1[i]] = i\n" +
            "\t\n" +
            "\tfor j in range (n):\n" +
            "\t\tmp2[perm2[j]] = j\n" +
            "\t\n" +
            "\tfor i in range (n):\n" +
            "\n" +
            "\t\t# idx1 is index of element\n" +
            "\t\t# in first permutation\n" +
            "\n" +
            "\t\t# idx2 is index of element\n" +
            "\t\t# in second permutation\n" +
            "\t\tidx2 = mp2[perm1[i]]\n" +
            "\t\tidx1 = i\n" +
            "\n" +
            "\t\tif (idx1 == idx2):\n" +
            "\n" +
            "\t\t\t# If element if present on same\n" +
            "\t\t\t# index on both permutations then\n" +
            "\t\t\t# distance is zero\n" +
            "\t\t\tleft[i] = 0\n" +
            "\t\t\tright[i] = 0\n" +
            "\t\t\n" +
            "\t\telif (idx1 < idx2):\n" +
            "\n" +
            "\t\t\t# Calculate distance from left\n" +
            "\t\t\t# and right side\n" +
            "\t\t\tleft[i] = (n - (idx2 - idx1))\n" +
            "\t\t\tright[i] = (idx2 - idx1)\n" +
            "\t\t\n" +
            "\t\telse :\n" +
            "\n" +
            "\t\t\t# Calculate distance from left\n" +
            "\t\t\t# and right side\n" +
            "\t\t\tleft[i] = (idx1 - idx2)\n" +
            "\t\t\tright[i] = (n - (idx1 - idx2))\n" +
            "\n" +
            "\t# Maps to store frequencies of elements\n" +
            "\t# present in left and right arrays\n" +
            "\tfreq1 = defaultdict (int)\n" +
            "\tfreq2 = defaultdict (int)\n" +
            "\tfor i in range (n):\n" +
            "\t\tfreq1[left[i]] += 1\n" +
            "\t\tfreq2[right[i]] += 1\n" +
            "\n" +
            "\tans = 0\n" +
            "\n" +
            "\tfor i in range( n):\n" +
            "\n" +
            "\t\t# Find maximum frequency\n" +
            "\t\tans = max(ans, max(freq1[left[i]],\n" +
            "\t\t\t\t\t\tfreq2[right[i]]))\n" +
            "\n" +
            "\t# Return the result\n" +
            "\treturn ans\n" +
            "\n" +
            "# Driver Code\n" +
            "if __name__ == \"__main__\":\n" +
            "\t\n" +
            "\t# Given permutations P1 and P2\n" +
            "\tP1 = [ 5, 4, 3, 2, 1 ]\n" +
            "\tP2 = [ 1, 2, 3, 4, 5 ]\n" +
            "\tn = len(P1)\n" +
            "\n" +
            "\t# Function Call\n" +
            "\tprint(maximumMatchingPairs(P1, P2, n))\n" +
            "\n"
            ;


}
