import Foundation

@objc public class CodeGet: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
