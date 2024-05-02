
/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.
 */

function main() {
  i = 0;
  //vec = [2147483645,2147483645,2147483645,2147483645,2147483645];
  vec = [0,0,0,0,0];
  while (i < 100000000) {
    vec = vec vec_add [1,1,1,1,1];

    i = i + 1;
  }

  return i;
}
