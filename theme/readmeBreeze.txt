How to use breeze.jar:

1. Put breeze.jar in WEB-INF/lib, then Breeze will become your default theme.

2. Now you can also dynamically switch between Breeze and Blue (the old ZK theme), 
which does not require a server restart, but user has to refeash the browser. To achieve this,
write zktheme=breeze in the cookie to use Breeze, zktheme=blue to use Blue. If no such entry
is in the cookie, Breeze is assumed.
