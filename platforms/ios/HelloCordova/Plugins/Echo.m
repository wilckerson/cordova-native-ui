//
//  Echo.m
//  HelloCordova
//
//  Created by Wilckerson Ganda on 25/10/14.
//
//

#import "Echo.h"
#import <Cordova/CDV.h>

@implementation Echo

- (void)echo:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];
    
    if (echo != nil && [echo length] > 0) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)nativeAlert:(CDVInvokedUrlCommand*)command
{
    NSString* msg = [command.arguments objectAtIndex:0];
    
 
    UIAlertView* alert = [[UIAlertView alloc] initWithTitle: @"Nativer Alert"
                                             message:msg
                                             delegate:self
                                             cancelButtonTitle: @"OK"
                                             otherButtonTitles: nil];
    [alert show];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
     [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end