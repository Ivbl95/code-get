export interface CodeGetPlugin {
    checkUpdates(options: {
        update_channel: string,
        current_app_version: string,
        platform: string,
    }): Promise<unknown>;
    installUpdates(): Promise<unknown>;
    rejectUpdates(): Promise<unknown>;
}
