import { WebPlugin } from '@capacitor/core';

import type { CodeGetPlugin } from './definitions';

export class CodeGetWeb extends WebPlugin implements CodeGetPlugin {
    public async checkUpdates(options: {
        update_channel: string,
        current_app_version: string,
        platform: string,
    }): Promise<unknown> {
        return options;
    }

    public async installUpdates(): Promise<unknown> {
        return;
    }

    public async rejectUpdates(): Promise<unknown> {
        return
    }
}
