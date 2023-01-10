import { WebPlugin } from '@capacitor/core';

import type { CodeGetPlugin } from './definitions';

export class CodeGetWeb extends WebPlugin implements CodeGetPlugin {
    async echo(options: { value: string }): Promise<unknown> {
        console.log('ECHO', options);
        return options;
    }

    public async checkUpdates(): Promise<unknown> {
        return;
    }

    public async installUpdates(): Promise<unknown> {
        return;
    }

    public async rejectUpdates(): Promise<unknown> {
        return
    }
}
