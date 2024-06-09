function main() {
    i = 0;
    while (i < 10000000) {
//Elements of size MAX_INT - 1
  vec1 = [2147483646,
          2147483646,
          2147483646,
          2147483646,
          2147483646];

  // [MAX_INT , MAX_INT , MAX_INT , MAX_INT , MAX_INT]
  vec1 = vec1 vec_add [1,1,1,1,1];

  // [MAX_INT+1, MAX_INT+1, MAX_INT+1, MAX_INT+1, MAX_INT+1] ->
  //Integer overflows! -> Specialize into Longs
  vec1 = vec1 vec_add [1,1,1,1,1];

  //add MAX_LONG -> Long Overflows -> BigInteger Specialization
  vec1 = vec1 vec_add [9223372036854775807,
                       9223372036854775807,
                       9223372036854775807,
                       9223372036854775807,
                       9223372036854775807];
        i = i+1;
    }

}





