# JavaEncryptDecrypt
 Encryption/Decryption with a numeric key (shift). Using files for input/output is possible.

This program can take six arguments from the CLI:

-mode: can be either "enc" for encryption (default) or "dec" for decryption.

-key: an integer that will determine how much each character will be shifted within either
the standard english alphabet or the unicode table. The default is 0.

-alg: can be either "unicode" or "shift" (default). "Shift" shifts the character along the alphabet
based on the key and leaves other characters untouched, so using "-alg shift -key 5 -data bee2" will
produce "gjj2". "Unicode" changes all characters and uses the unicode table instead of the alphabet.

-data: it's the message to be encrypted or decrypted. The standard is an empty string.

-in: if there is a file to serve as input, you can use this argument.

-out: if there is a file to serve as output, you can use this argument.

