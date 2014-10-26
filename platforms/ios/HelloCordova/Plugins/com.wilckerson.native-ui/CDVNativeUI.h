#import <Cordova/CDV.h>

@interface CDVNativeUI : CDVPlugin

- (void)nativeAlert:(CDVInvokedUrlCommand*)command;
- (void)addButton:(CDVInvokedUrlCommand*)command;

-(void)controlEventTouchUpInside:(id) sender;
-(void) sendEvent: (NSString *)eventName forControlID: (NSInteger)ID;

@end