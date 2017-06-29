
silvergray.jar: The gray theme for ZK 5. The gray theme takes effect when you include this jar file.

silvergray-tod.jar: The switchable gray theme for ZK 5. With this file, you can switch between the gray theme and the default blue theme on demand.

If you need further assitance, please contact us at <info@zkoss.org>. 


How to use breeze.jar:

1. Put breeze.jar in WEB-INF/lib, then Breeze will become your default theme.

2. Now you can also dynamically switch between Breeze and Classic Blue (the old ZK theme). 
It does not require a server restart, but user has to refeash the browser.
To switch the theme, write zktheme=breeze in the cookie to use Breeze, zktheme=blue to use Blue.
If no such entry is in the cookie, Breeze is assumed.
