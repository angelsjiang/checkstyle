package com.puppycrawl.tools.checkstyle.checks.blocks.emptyblock;

/* Config:
 * option = "statement"
 * tokens = "LITERAL_CASE"
 */
class InputEmptyBlockCase2
{
    void method1(int a) {
        switch (a) {}
        switch (a) {case 1: ; } // ok
        switch (a) {case 1:{}}  // violation
        switch (a) {
            case 1:
        }
        switch (a) {
            case 1:
            {}  // violation
        }
        switch (a) {
            case 1:
            {   // violation
            }
        }
    }

    public void method2(char c) {
        switch(c) { case 0: }   // ok
        switch(c) { case 0: {} method1(1); }    // violation
        switch(c) { case 0: method1(0); {} }    // ok
        switch(c) { case 0: case 1: {} }    // violation
        switch(c) { case 0: {} case 1: {    // violation
        }
        }
    }
}
