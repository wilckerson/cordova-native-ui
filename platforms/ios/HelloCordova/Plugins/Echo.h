//
//  Echo.h
//  HelloCordova
//
//  Created by Wilckerson Ganda on 25/10/14.
//
//

#import <Cordova/CDV.h>

@interface Echo : CDVPlugin

- (void)echo:(CDVInvokedUrlCommand*)command;

- (void)nativeAlert:(CDVInvokedUrlCommand*)command;
@end