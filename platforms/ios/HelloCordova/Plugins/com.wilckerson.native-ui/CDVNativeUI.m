
#import "CDVNativeUI.h"
#import <Cordova/CDV.h>

@implementation CDVNativeUI

//static int elementsId= 0;

-(void) initView:(CDVInvokedUrlCommand*)command
{
    //UINavigationController* navigationController = [[UINavigationController alloc] init];
    //navigationController.title = @"Titulo";
    
//    UIViewController* uiViewController = [[UIViewController alloc]init];
//    UIButton* uiButton = [[UIButton alloc] init];
//    [uiButton setTitle:@"Button" forState:UIControlStateNormal];
//
//    [uiViewController.view addSubview:uiButton];
//    
//    [self.viewController.navigationController pushViewController:uiViewController animated:true];
    //= navigationController;
    
    //[self.viewController.view addSubview:navigationController.];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

}
/*
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

- (void)addButton:(CDVInvokedUrlCommand*)command
{
    NSString* title = [command.arguments objectAtIndex:0];
    
    
    UIButton *button = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    //    [button addTarget:self
    //               action:@selector(aMethod:)
    //     forControlEvents:UIControlEventTouchUpInside];
    [button setTitle:title forState:UIControlStateNormal];
    button.frame = CGRectMake(80.0, 210.0, 160.0, 40.0);
    
    [self.viewController.view addSubview:button];
    
    int elementId = elementsId++;
    
    button.tag = elementId;
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsInt:elementId];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

}

-(void)controlEventTouchUpInside:(id) sender { [self sendEvent:@"onClick" forControlID: ((UIView*)sender).tag]; }
*/

/**
 * triggers an event in the webview
 */
/*-(void) sendEvent: (NSString *)eventName forControlID: (NSInteger)ID
{

        [[self commandDelegate] evalJs:[NSString stringWithFormat:@"setTimeout( function() { cordova.fireDocumentEvent('NativeEvent','%d','%@') }, 0);", (int)ID, eventName]];
    
}*/

@end