# Add the following lines to the end of the file.

# This tells R8 not to issue a warning or error if it can't find
# classes from the javax.annotation package. This directly solves the error.
-dontwarn javax.annotation.**

# As a best practice, this rule ensures that if the Nullable annotation
# is present, it's not stripped out.
-keep class javax.annotation.Nullable { *; }
