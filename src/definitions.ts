export interface CodeGetPlugin {
    echo(options: { value: string }): Promise<unknown>;
    checkUpdates(): Promise<unknown>;
    installUpdates(): Promise<unknown>;
    rejectUpdates(): Promise<unknown>;
}
