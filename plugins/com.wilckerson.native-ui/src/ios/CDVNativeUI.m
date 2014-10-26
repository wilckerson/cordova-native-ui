
#import "CDVNativeUI.h"
#import <Cordova/CDV.h>

@implementation CDVNativeUI

- (void)nativeAlert:(CDVInvokedUrlCommand*)command
{
    NSString* msg = [command.arguments objectAtIndex:0];
    
 
    UIAlertView* alert = [[UIAlertView alloc] initWithTitle: @"Native Alert"
                                             message:msg
                                             delegate:self
                                             cancelButtonTitle: @"OK"
                                             otherButtonTitles: nil];
    [alert show];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
     [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end